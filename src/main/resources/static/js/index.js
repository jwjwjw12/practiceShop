'use strict'

let productCategoriesNav = document.querySelector('#dropdown-categories');

$.ajax({
    type: "GET",
    url: "/api/category",
    async:false,
    success: function (data) {
        console.log(data);
        makeCategories(data)
    }
})

function makeCategories(categoryArr) {

    for (let i in categoryArr) {
        let name = categoryArr[i].name;
        let id = categoryArr[i].id;

        console.log(name + ", " + id);

        let categoryName = document.createElement("a");
        categoryName.innerText = name;
        if(i == 0)
            categoryName.setAttribute("class", "dropdown-item mb-3 mt-3");
        else
            categoryName.setAttribute("class", "dropdown-item mb-3");
        categoryName.setAttribute("href", "/productList/" + id);
        productCategoriesNav.appendChild(categoryName);
    }
}
