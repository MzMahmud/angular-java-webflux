import { ApplicationConfig, provideZoneChangeDetection, isDevMode } from '@angular/core';
import { provideRouter } from '@angular/router';

import { provideStore } from '@ngrx/store';
import * as echarts from 'echarts/core';
import { provideEchartsCore } from 'ngx-echarts';
import { routes } from './app.routes';
import { appStore } from './store';
import { provideStoreDevtools } from '@ngrx/store-devtools';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideStore(appStore),
    provideEchartsCore({ echarts }),
    provideStoreDevtools({ maxAge: 25, logOnly: !isDevMode() })
],
};
