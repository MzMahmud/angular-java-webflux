import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { provideStore } from '@ngrx/store';
import * as echarts from 'echarts/core';
import { provideEchartsCore } from 'ngx-echarts';
import { routes } from './app.routes';
import { appStore } from './store';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideStore(appStore),
    provideEchartsCore({ echarts }),
  ],
};
