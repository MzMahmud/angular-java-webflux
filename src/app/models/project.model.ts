export type ProjectStatus = 'Pending' | 'In Progress' | 'Completed';

export type Project = {
  id: string;
  name: string;
  owner: string;
  status: ProjectStatus;
};
