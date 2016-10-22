var webpack = require('webpack');
var commonsPlugin = new webpack.optimize.CommonsChunkPlugin('common.js');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
//var ignoreFiles = new webpack.IgnorePlugin(/angular([\w.-]*).js$/);
var path = require("path");
module.exports = {
    devtool: "source-map",
    //插件项
    plugins: [commonsPlugin,
        /*        new webpack.ProvidePlugin({
         jQuery: "jquery",
         $: "jquery"
         }),*/
        new ExtractTextPlugin("../style/[name].css")
    ],
//页面入口文件配置
    entry: {
        "index": './static/src/js/app.js'
    },
//入口文件输出配置
    output: {
        //libraryTarget: "commonjs",
        path: path.join(__dirname, config.path.dist),
        // publicPath: './vendor/',
        filename: '[name].js'
    }
    ,
    module: {
        //加载器配置
        loaders: [
            /*{test: /\.css$/, loader: 'style-loader!css-loader'},*/
            {test: /\.less$/, loader: ExtractTextPlugin.extract("style-loader", "css-loader!less-loader")},
            {test: /\.css$/, loader: ExtractTextPlugin.extract("style-loader", "css-loader")},
            /* {test: /\.js$/, loader: 'jsx-loader?harmony'},*/
            {test: /\.js$/, loader: 'jsx-loader!script-loader'},
            {test: /angular([\w.-]*).js$/, loader: "exports?angular"},
            {test: /\.(gif|jpg|png)\??.*$/, loader: 'url-loader?limit=50000&name=../img/[name].[ext]'},
            {test: /\.(woff|woff2|svg|eot|ttf)\??.*$/, loader: 'url-loader?limit=50000&name=../fonts/[name].[ext]'}
        ]
    },
    /*    externals: [
     {
     'jquery': true,
     'bootstrap': true,
     'angular': true,
     'angular-ui-router': true,
     'bootstrap-css': true
     }
     ],*/
//其它解决方案配置
    resolve: {
        root: __dirname, //绝对路径
        extensions: ['', '.js', '.json', '.css', '.less'],
        alias: {
            'jquery': ["vendor/jquery/dist/jquery.min.js"],
            'bootstrap': ["vendor/bootstrap/dist/js/bootstrap.min.js"],
            'domReady': 'vendor/domReady/domReady.js',
            'angular': 'vendor/angular/angular.min.js',
            'angular-ui-router': 'vendor/angular-ui-router/release/angular-ui-router.js',
            'angular-async-loader': 'vendor/angular-async-loader/dist/angular-async-loader.js',
            'bootstrap-css': [path.join(__dirname, 'vendor/bootstrap/dist/css/bootstrap.min.css')]
        }
    }
}
;
