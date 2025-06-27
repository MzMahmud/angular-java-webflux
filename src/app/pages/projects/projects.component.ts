import { Component, OnInit, Signal } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../../store';
import { Project } from '../../models/project.model';
import { selectProjects } from '../../store/project/project.selector';
import { loadAllProjects } from '../../store/project/project.action';

@Component({
  selector: 'app-projects',
  imports: [],
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
}
