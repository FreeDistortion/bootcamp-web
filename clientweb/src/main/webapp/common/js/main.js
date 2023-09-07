/**
 * 
 */
 let idInputVal=document.querySelector("#exampleInputEmail1");
 let loginmodal=document.querySelector("#exampleModal");
 
 loginmodal.addEventListener("shown.bs.modal",function(){
	alert("loginmodal.addEventListener executed");
	idInputVal.focus();
});