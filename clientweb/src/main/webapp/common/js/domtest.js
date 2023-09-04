/**
 * 
 */
 //alert("test");
 let divobj1=document.querySelector(".mybox");
 
 //dom 객체에 event 연결하기
 //객체.addEventListener("이벤트명",이벤트가 발생할 떄 실행할 함수)
 divobj1.addEventListener("click",function(){
	
	divobj1.style.backgroundColor="red";
	divobj1.style.color="blue";
	
	
	alert("event occcured.");
	
	
	//element에 class를 여러 단계로 정의하기 위해
	divobj1.classList.add("active");
	console.log(divobj1.classList.contains("active"));
	divobj1.classList.remove("active");
	console.log(divobj1.classList.contains("active"));

	//getter의 역할
	console.log(divobj1.textContent);
	//setter의 역할
	divobj1.textContent="hello DOM";
});