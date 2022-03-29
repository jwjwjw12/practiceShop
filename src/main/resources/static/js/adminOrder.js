'use strict'

const yet_orders_container = document.querySelector("#yet-orders-container");
const okay_orders_container = document.querySelector("#okay-orders-container");
let checkedId = new Array();

$.ajax({
    type: "GET",
    url: "/api/orders/yet/all",
    async: false,
    success: function (data) {
        for (let i in data) {
            const buyer = data[i].member.viewName;
            const productName = data[i].product.name;
            const date = new Date(data[i].date);
            const orderId = data[i].id;

            let orders = `<ul class="list-group list-group-horizontal">
                <li class="list-group-item flex-fill">
                    <input class="form-check-input me-1" type="checkbox" value="`+orderId+`" aria-label="..." onclick="check(this)">
                        `+productName+`
                </li>
                <li class="list-group-item flex-fill">`+buyer+`</li>
                <li class="list-group-item flex-fill">
                    <div class="row">
                        <div class="text-start col">`+date.toLocaleDateString()+`</div>
                        <div class="text-end col">
                            <div class="dropdown">
                                <button class="btn btn-sm top-btn" type="button" id="dropdown-order-btn-1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fas fa-ellipsis-v"></i>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-dark" id="dropdown-order-1" aria-labelledby="dropdown-order-1">
                                    <a th:href="@{#}" class="dropdown-item mb-3 mt-3">상세 보기</a>
                                    <a th:href="@{#}" class="dropdown-item mb-3 mt-3">주문 확정</a>
                                    <a th:href="@{#}" class="dropdown-item mb-3 mt-3">주문 취소</a>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>`

            yet_orders_container.innerHTML += orders;
        }
    }
})

$.ajax({
    type: "GET",
    url: "/api/orders/okay/all",
    async: false,
    success: function (data) {
        for (let i in data) {
            const buyer = data[i].member.viewName;
            const productName = data[i].product.name;
            const date = new Date(data[i].date);
            const orderId = data[i].id;

            let orders = `<ul class="list-group list-group-horizontal">
                <li class="list-group-item flex-fill">`+productName+`</li>
                <li class="list-group-item flex-fill">`+buyer+`</li>
                <li class="list-group-item flex-fill">
                    <div class="row">
                        <div class="text-start col">`+date.toLocaleDateString()+`</div>
                        <div class="text-end col">
                            <div class="dropdown">
                                <button class="btn btn-sm top-btn" type="button" id="dropdown-order-btn-1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fas fa-ellipsis-v"></i>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-dark" id="dropdown-order-1" aria-labelledby="dropdown-order-1">
                                    <a th:href="@{#}" class="dropdown-item mb-3 mt-3">상세 보기</a>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>`

            okay_orders_container.innerHTML += orders;
        }
    }
})

function check(box){
    if(box.checked == true){
        checkedId.push(box.getAttribute("value"));
    }
    else {
        const idx = checkedId.indexOf(box.getAttribute("value"));
        checkedId.splice(idx, 1);
    }
}

function order_btn(){
    $.ajax({
        type: "GET",
        url: "/api/orders/state/list",
        async: false,
        data: {
            ids: checkedId,
            state: 1
        },
        success: function (data) {
            location.reload();
            checkedId = new Array();
        }
    })
}

function cancel_btn(){
    $.ajax({
        type: "GET",
        url: "/api/orders/state/list",
        async: false,
        data: {
            ids: checkedId,
            state: -1
        },
        success: function (data) {
            location.reload();
            checkedId = new Array();
        }
    })
}