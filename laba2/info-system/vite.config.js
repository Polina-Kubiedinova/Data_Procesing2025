import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'


// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  /*build: {
    outDir: 'dist',
    emptyOutDir: true
  },*/
  //base: '/Cosmetic_3/',
  server: {
    proxy: {
      '/cos': {
        target: 'http://localhost:9090/Cosmetic_3/',
        changeOrigin: true,
        secure: false
      },
      //'/images': 'http://localhost:9090/Cosmetic_3/',
    }
  }
});

