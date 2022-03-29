'use strict'

const category_list = document.querySelector("#category-list");
const mini_list = document.querySelector("#mini-list");
const product_list = document.querySelector("#product-list");

const mini_category = document.querySelector("#mini_category");

const product_category = document.querySelector("#product_category");
const product_mini = document.querySelector("#product_mini");

const category_name = document.querySelector("#category-name");
const mini_name = document.querySelector("#mini-name");

$.ajax({
    type: "GET",
    url: "/api/category",
    async:false,
    success: function (data) {
        for(let i in data){
            const name = data[i].name;
            const id = data[i].id;
            let category = `<div class="row">
                                <div class="col">
                                    <button class="btn" onclick="getMini(`+id+`,'`+name+`')"><h5>`+name+`</h5></button>
                                </div>
                                <div class="col align-items-end">
                                    <button class="btn"><i class="fas fa-pen"></i></button>
                                    <button class="btn" onclick="deleteCategory(`+id+`)"><i class="fas fa-trash"></i></>
                                </div>
                             </div>`
            category_list.innerHTML += category;

            let product_opt = document.createElement("option");
            product_opt.setAttribute("value", id);
            product_opt.innerText = name;
            product_category.appendChild(product_opt);

            let mini_opt = document.createElement("option");
            mini_opt.setAttribute("value", id);
            mini_opt.innerText = name;
            mini_category.appendChild(mini_opt);
        }
    }
})

function getMini(category, name){
    category_name.innerText = name;
    $.ajax({
        type: "GET",
        url: "/api/mini/category/" + category,
        async: false,
        success: function (data){
            mini_list.innerHTML = "";
            product_list.innerHTML = "";
            for(let i in data){
                const name = data[i].name;
                const id = data[i].id;
                let mini = `<div class="row">
                                <div class="col">
                                    <button class="btn" onclick="getProduct(`+category+`,`+id+`,'`+name+`')"><h5>`+name+`</h5></button>
                                </div>
                                <div class="col align-items-end">
                                    <button class="btn"><i class="fas fa-pen"></i></button>
                                    <button class="btn" onclick="deleteMini(`+id+`)"><i class="fas fa-trash"></i></>
                                </div>
                             </div>`
                mini_list.innerHTML += mini;
            }
        }
    })
}

function getProduct(category, mini, name){
    mini_name.innerText = name;
    $.ajax({
        type: "GET",
        url: "/api/product/category/" + category + "/mini/" + mini,
        async: false,
        success: function (data){
            product_list.innerHTML = "";
            for(let i in data){
                const name = data[i].name;
                const id = data[i].id;
                let product = `<div class="row">
                                <div class="col">
                                    <button class="btn"><h5>`+name+`</h5></button>
                                </div>
                                <div class="col align-items-end">
                                    <button class="btn"><i class="fas fa-pen"></i></button>
                                    <button class="btn" onclick="deleteProduct(`+id+`)"><i class="fas fa-trash"></i></>
                                </div>
                             </div>`
                product_list.innerHTML += product;
            }
        }
    })
}

function deleteCategory(category_Id){
    $.ajax({
        type: "GET",
        url: "/api/category/delete/" + category_Id,
        async: false,
        success: function (data){
            if(data == 'fail')
                alert('해당 카테고리안의 미니 카테고리를 모두 삭제해야 삭제 할 수 있습니다.');
            else
                location.reload();
        }
    })
}

function deleteMini(mini_Id){
    $.ajax({
        type: "GET",
        url: "/api/mini/delete/" + mini_Id,
        async: false,
        success: function (data){
            if(data == 'fail')
                alert('해당 미니 카테고리안의 상품을 모두 삭제해야 삭제 할 수 있습니다.');
            else
                location.reload();
        }
    })
}

function deleteProduct(product_Id){
    $.ajax({
        type: "GET",
        url: "/api/product/delete/" + product_Id,
        async: false,
        success: function (data){
            location.reload();
        }
    })
}

function setProduct_Mini(category){
    const value = category.value;
    document.querySelector("#product_category_default").setAttribute("disabled", "true");
    $.ajax({
        type: "GET",
        url: "/api/mini/category/" + value,
        async: false,
        success: function (data){
            product_mini.innerHTML = "";
            for(let i in data){
                const name = data[i].name;
                const id = data[i].id;
                let mini = document.createElement("option");
                mini.setAttribute("value", id);
                mini.innerText = name;
                product_mini.appendChild(mini);
            }
        }
    })
}