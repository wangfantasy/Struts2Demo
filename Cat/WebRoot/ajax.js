function createAJAX(){
	var XHR;
	
	if(window.XMLHttpRequest){
		XHR=new XMLHttpRequest();
	}else {
		XHR=new ActiveXObject("Msxml2.XMLHTTP");
	}
	
	return XHR;

}
