import { Component, computed, OnInit, Signal } from '@angular/core';
import { Store } from '@ngrx/store';
import { AgGridAngular } from 'ag-grid-angular';
import type { ColDef } from 'ag-grid-community';
import { PieChart } from 'echarts/charts';
import { LegendComponent, TooltipComponent } from 'echarts/components';
import type { EChartsCoreOption } from 'echarts/core';
import * as echarts from 'echarts/core';
import { CanvasRenderer } from 'echarts/renderers';
import { NgxEchartsDirective } from 'ngx-echarts';
import { Project } from '../../models/project.model';
import { AppState } from '../../store';
import { loadAllProjects } from '../../store/project/project.action';
import { selectProjects } from '../../store/project/project.selector';
import { getNumberOfProjectsByStatusCount } from '../../util/project.util';
import { Title } from '@angular/platform-browser';

echarts.use([PieChart, CanvasRenderer, TooltipComponent, LegendComponent]);

@Component({
  selector: 'app-projects',
  imports: [AgGridAngular, NgxEchartsDirective],
  templateUrl: './projects.component.html',
})
export class ProjectsComponent implements OnInit {
  projects: Signal<Project[]>;

  pieChartData = computed(() => {
    const statusCount = getNumberOfProjectsByStatusCount(this.projects());
    const data = [...statusCount].map(([name, value]) => ({ name, value }));
    const mergeOptions = { series: [{ data }] };
    return mergeOptions;
  });

  constructor(private store: Store<AppState>, private titleService: Title) {
    this.projects = this.store.selectSignal(selectProjects);
  }

  ngOnInit(): void {
    this.titleService.setTitle('Projects');
    this.store.dispatch(loadAllProjects());
  }

  colDefs: ColDef<Project>[] = [
    { field: 'name' },
    { field: 'owner' },
    { field: 'status' },
  ];

  defaultColDef: ColDef<Project> = {
    flex: 1,
    filter: true,
  };

  options: EChartsCoreOption = {
    tooltip: {
      trigger: 'item',
    },
    legend: {
      orient: 'vertical',
      top: 0,
      right: 0,
      align: 'right',
    },
    series: [
      {
        type: 'pie',
        radius: ['40%', '80%'],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: '#fff',
          borderWidth: 2,
        },
        label: {
          show: false,
        },
        labelLine: {
          show: false,
        },
      },
    ],
  };
}
