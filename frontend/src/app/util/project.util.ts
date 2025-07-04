import { Project, ProjectStatus } from '../models/project.model';

export function getNumberOfProjectsByStatusCount(projects: Project[]) {
  return projects.reduce((map, project) => {
    const status = project.status;
    const count = (map.get(status) ?? 0) + 1;
    map.set(status, count);
    return map;
  }, new Map<ProjectStatus, number>());
}
