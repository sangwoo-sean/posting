const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    outputDir: "../src/main/resources/static",
    indexPath: "../static/index.html",
    devServer: {
        port: 3000
    },
})
