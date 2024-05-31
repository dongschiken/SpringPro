/**
 * 
 */
 
var httpRequest = null; 

function getXMLHttpRequest(){
   if(window.ActiveXObject){  
      try {
         return new ActiveXObject("Msxml2.XMLHTTP");
      } catch (e) {
         try {
            return new ActivXObject("Microsoft.XMLHTTP");
         } catch (e) {
            return null;
         }

      }
   }else if(window.XMLHttpRequest){
      return new XMLHttpRequest();       
   }else {
      return null;
   }
}


function sendRequest(url,params,callback,method){     
   httpRequest = getXMLHttpRequest();        
   httpRequest.onreadystatechange = callback; 
   var httpMethod= method ? method : 'GET';   
   if(httpMethod!='GET' && httpMethod!='POST') httpMethod='GET';
   var httpParams = (params==null||params=="")?null:params;
   var httpUrl = url;
   if(httpMethod=='GET' && httpParams != null){
      httpUrl= httpUrl +"?"+httpParams;
   }     
   httpRequest.open(httpMethod,httpUrl,true);  
   httpParams = (httpMethod=='POST'?httpParams:null );
   httpRequest.send( httpParams );  
}