import { Component, OnInit, Signal } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../../store';
import { Project } from '../../models/project.model';
import { selectProjects } from '../../store/project/project.selector';
import { loadAllProjects } from '../../store/project/project.action';
import { AgGridAngular } from 'ag-grid-angular';
import type { ColDef } from 'ag-grid-community';

@Component({
  selector: 'app-projects',
  imports: [AgGridAngular],
  templateUrl: './projects.component.html',
})
export class ProjectsComponent implements OnInit {
  projects: Signal<Project[]>;

  constructor(private store: Store<AppState>) {
    this.projects = this.store.selectSignal(selectProjects);
  }

  ngOnInit(): void {
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
}
