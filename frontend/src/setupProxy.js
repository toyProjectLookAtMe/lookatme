const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
    app.use(
        createProxyMiddleware(['/api', '/user'],{
            target: process.env.REACT_APP_HOST,
            changeOrigin: true,
        })
    );
}