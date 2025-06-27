import { createFeatureSelector, createSelector } from '@ngrx/store';
import { projectsKey, ProjectState, projectStateKey } from './project.state';
import { Project } from '../../models/project.model';

export const selectProjectState =
  createFeatureSelector<ProjectState>(projectStateKey);

export const selectProjects = createSelector(
  selectProjectState,
  createFeatureSelector<Project[]>(projectsKey)
);
