var gulp = require("gulp");

var fs = require("fs");
var rename = require('gulp-rename');
var rev = require("gulp-rev");
var path = require("path");

var config = {
    path: {
        src: {
            js: "static/src/js/**/*.js",
            css: 'static/src/css/**/*.css',
            img: 'static/src/img/**/*.*'
        },
        dist: "../resources/static/dist/"
    }
};
/*将bower.json中配置的文件拷贝到vendor目录下*/
gulp.task('bower', function () {
    var mainBowerFiles = require('main-bower-files');
    return gulp.src(mainBowerFiles(), {base: './bower_components'})
        .pipe(gulp.dest(path.join(__dirname,config.path.dist +"/vendor")));
});
var webpackConfig = require("./webpack.config.js");
gulp.task("webpack", function (callback) {
    var myConfig = Object.create(webpackConfig);
    webpack(myConfig, function (err, stats) {
        callback();
    });
});
gulp.task('default', ['bower', 'webpack'], function () {
    /*    gulp.watch('./static/src/!**!/!*.js', ['webpack']);
     gulp.watch('./static/src/!**!/!*.css', ['webpack']);*/
});

var webpack = require("webpack");
