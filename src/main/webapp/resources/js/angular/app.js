var categoriesApp = angular.module('categoriesApp',
    ['ngRoute', 'catControllers']);
categoriesApp.config(['$routeProvider', function ( $routeProvider) {
    $routeProvider
        .when('/main', {
            templateUrl: 'partials/main.html',
            controller: 'TestDataController'
        })
        .when('/showAllCategories', {
            templateUrl: 'partials/showAllCategories.html',
            controller: 'CategoryController'
        })
        .when('/createCategory', {
            templateUrl: 'partials/createCategory.html',
            controller: 'CategoryController'
        })
        .when('/updateCategory', {
            templateUrl: 'partials/updateCategory.html',
            controller: 'CategoryController'
        })
        .when('/deleteCategory', {
            templateUrl: 'partials/deleteCategory.html',
            controller: 'CategoryController'
        })
        .otherwise({
            redirectTo: '/main'
        });
}]);
