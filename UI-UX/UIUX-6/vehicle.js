var vh_name,vh_type,vh_number,vh_id,vh_brief;

var vh_details = {
    "id" : vh_id,
    "name" : vh_name,
    "number" : vh_number,
    "type" : vh_type,
    "brief" : vh_brief,
    "cycle" : {
        "daily" : 5,
        "monthly" : 100,
        "yearly"  : 500
    },
    "motercycle" : {
        "daily" : 10,
        "monthly" : 200,
        "yearly"  : 1000
    },
    "fourwheeler" : {
        "daily" : 20,
        "monthly" : 500,
        "yearly"  : 3500
    }
};

function createVehicle(){
    vh_name = document.getElementById("Vname").value;
    var getSelectedValue = document.querySelector('input[name="type"]:checked');   
    vh_type= getSelectedValue.value;
    vh_number = document.getElementById("Vnumber").value;
    vh_id = document.getElementById("Vid").value;
    vh_brief = document.getElementById("identification").value;
    vh_details.name = vh_name;
    vh_details.type = vh_type;
    vh_details.number = vh_number;
    vh_details.id = vh_id;
    vh_details.brief = vh_brief;
}

function displaypricing(){
    if(vh_type == "motercycle"){
       document.getElementById("h1").innerHTML = "Moter Cycle";
       document.getElementById("h2").innerHTML = "Moter Cycle";
       document.getElementById("h3").innerHTML = "Moter Cycle";
       document.getElementById("daily").innerHTML = "$10";
       document.getElementById("monthly").innerHTML = "$200";
       document.getElementById("yearly").innerHTML = "$1000"; 
    } else if(vh_type == "fourwheeler"){
        document.getElementById("h1").innerHTML = "Four Wheeler";
       document.getElementById("h2").innerHTML = "Four Wheeler";
       document.getElementById("h3").innerHTML = "Four Wheeler";
       document.getElementById("daily").innerHTML = "$20";
       document.getElementById("monthly").innerHTML = "$500";
       document.getElementById("yearly").innerHTML = "$3500"; 
    }
}

function rupee(){
    var types = vh_details.type;
    document.getElementById("daily").innerHTML = (vh_details[types].daily * 73.38).toFixed(2) + " RS";
    document.getElementById("monthly").innerHTML = (vh_details[types].monthly*73.38).toFixed(2) + " RS";
    document.getElementById("yearly").innerHTML = (vh_details[types].yearly * 73.38).toFixed(2) + " RS";
}

function usd(){
    var types = vh_details.type;
    document.getElementById("daily").innerHTML = "$" + vh_details[types].daily;
    document.getElementById("monthly").innerHTML = "$"+ vh_details[types].monthly;
    document.getElementById("yearly").innerHTML = "$"+ vh_details[types].yearly;
}

function yen(){
    var types = vh_details.type;
    document.getElementById("daily").innerHTML = (vh_details[types].daily*110.70).toFixed(2) +" YEN";
    document.getElementById("monthly").innerHTML = (vh_details[types].monthly*110.70).toFixed(2)+" YEN";
    document.getElementById("yearly").innerHTML = (vh_details[types].yearly*110.70).toFixed(2)+" YEN"
}