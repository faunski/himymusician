/**
 * Created by Khanh on 5/8/2017.
 */
$(document).ready(function(){
});
    

$("#searchBtn").click(function(){
    
    $.get("search?genre="+$("#genreselect option:selected").text(),function(data){
        console.log($("#genreselect option:selected").text());
        console.log(data);
       $("#search-result").html(data); 
        
    });
    
});