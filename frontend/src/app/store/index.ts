import { ActionReducer, Action } from '@ngrx/store';
import { projectReducer } from './project/project.reducer';
import { projectStateKey } from './project/project.state';

export const appStore = {
  [projectStateKey]: projectReducer,
};

type ExtractState<T> = T extends ActionReducer<infer S, Action> ? S : never;

type AppStore = typeof appStore;

export type AppState = {
  [K in keyof AppStore]: ExtractState<AppStore[K]>;
};
