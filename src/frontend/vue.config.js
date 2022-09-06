const { defineConfig } = require('@vue/cli-service')
const path = require('path');


module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../main/resources/static',
  devServer: {
    port: 8080,
    proxy: {
      '/api': {
        target: 'http://localhost:8081'
      }
    }
  },
  // configureWebpack: {
  //   resolve: {
  //     alias: {
  //       // 자주쓰는 경로인 src/components/board를 BOARD라는 키워드로 묶어서 사용하여 낭비를 줄임
  //       'BOARD': path.join(__dirname, 'src/components/board')
  //
  //     }
  //   }
  // }

})
