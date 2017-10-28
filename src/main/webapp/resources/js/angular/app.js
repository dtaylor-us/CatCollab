var categoriesApp = angular.module('categoriesApp',
    ['ngRoute', 'catControllers']);
categoriesApp.config(['$routeProvider', function ( $routeProvider) {
    $routeProvider
        .when('/main', {
            templateUrl: 'resources/js/angular/partials/main.html',
            controller: 'TestDataController'
        })
        .when('/showAllCategories', {
            templateUrl: 'angular/partials/showAllCategories.html',
            controller: 'CategoryController'
        })
        .when('/createCategory', {
            templateUrl: 'angular/partials/createCategory.html',
            controller: 'CategoryController'
        })
        .when('/updateCategory', {
            templateUrl: 'angular/partials/updateCategory.html',
            controller: 'CategoryController'
        })
        .when('/deleteCategory', {
            templateUrl: 'angular/partials/deleteCategory.html',
            controller: 'CategoryController'
        })
        .otherwise({
            redirectTo: '/main'
        });
}]);

categoriesApp.run(['$http', function ( $http) {

}]);
