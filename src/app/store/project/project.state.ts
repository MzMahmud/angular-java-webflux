import { Project } from '../../models/project.model';

export const projectStateKey = 'project';
export const projectsKey = 'projects';

export type ProjectState = {
  [projectsKey]: Project[];
};
