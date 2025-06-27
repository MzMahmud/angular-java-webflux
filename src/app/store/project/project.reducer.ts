import { createReducer, on } from '@ngrx/store';
import { ProjectState } from './project.state';
import { loadAllProjects } from './project.action';
import { projects } from '../../data/project.data';

const initialState: ProjectState = {
  projects: [],
};

export const projectReducer = createReducer(
  initialState,
  on(loadAllProjects, (state) => ({ ...state, projects: [...projects] }))
);
