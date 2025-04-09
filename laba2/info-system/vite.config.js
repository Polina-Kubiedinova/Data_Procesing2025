import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'


// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  build: {
    outDir: 'dist',
    emptyOutDir: true
  },
  base: '/laba2-1.0-SNAPSHOT/',
  server: {
    proxy: {
      '/cos': {
        target: 'http://localhost:9090/laba2-1.0-SNAPSHOT/',
        changeOrigin: true,
        secure: false
      },
      '/images': 'http://localhost:9090/laba2-1.0-SNAPSHOT/',
    }
  }
});

