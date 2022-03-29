'use strict'

const productId = window.location.pathname.split('/')[2];
const question_btn = document.querySelector('#question-btn');
const ask_list = document.querySelector('#ask-list');

question_btn.addEventListener("click", function (){
   const question = $('#question-area').val();
   $.ajax({
       type: "GET",
       url: "/api/question/add/" + productId,
       async: false,
       data:{
         question: question
       },
       success: function (data) {
           console.log("success");
       }
   })
    location.reload();
});

$.ajax({
    type: "GET",
    url: "/api/order/reviews/product/" + productId,
    async:false,
    success: function (data) {
        console.log(data);
    }
})

$.ajax({
    type: "GET",
    url: "/api/question/product/" + productId,
    async:false,
    success: function (data) {
        console.log(data);
        makeQuestions(data);
    }
})

function makeQuestions(questions){

    for(let i in questions){
        const name = questions[i].member.viewName;
        const question = questions[i].question;
        const date = new Date(questions[i].date);
        let answer = "답변 없음";
        if(questions[i].state == 2)
            answer = questions[i].answer;

        const qeustion_div = `                    
                    <div class="ask-container ms-5 mt-5">
                        <div class="question">
                            <div class="row m-3">
                                <div class="col-sm-3">
                                    <p class="h5">`+name+`</p>
                                </div>
                                <div class="col-5">
                                    <p class="h5">`+date.toLocaleDateString()+`</p>
                                </div>
                            </div>
                            <div class="row-cols-2 m-4">
                                <p class="h6">
                                    `+question+`
                                </p>
                            </div>
                            <hr style="height: 2px">
                        </div>
                        <div class="answer mt-5">
                            <div class="row m-3">
                                <div class="col-sm-3">
                                    <p class="h5"><i class="fas fa-arrow-right"></i> 판매자</p>
                                </div>
                                <div class="col-5">
                                    <p class="h5">`+date.toLocaleDateString()+`</p>
                                </div>
                            </div>
                            <div class="row-cols-2 m-4 ms-5">
                                <p class="h6">
                                    `+answer+`
                                </p>
                            </div>
                            <hr style="height: 2px">
                        </div>
                    </div>`
        ask_list.innerHTML += qeustion_div;
    }
}