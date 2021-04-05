var employeedetail = {
    gender: "! Can i know your gender",
    emailid: "! Can i know your email",
    password: "! Can i know your password",
    confirms: "! Can you enter your password again!",
    contact: "! Can I know your contact number"
};

var vehicle = {
    v_type: "Which vehicle do you have ?",
    v_number: "Can I know your vehicle number",
    emp_id: "Can I know your id",
    v_identification: "Can you tell something about your vehicle"
};

var emp_id = 1;

function myFunction(name, nextname) {
    var x = document.getElementById("name").value;
    document.getElementById(name).style.display = "none";
    document.getElementById("demo").innerHTML = "Hi " + x + employeedetail[nextname];
    document.getElementById(nextname).style.display = "block";
}

function collapseEmployee(name, current, next) {
    document.getElementById(current).style.display = "block";
    document.getElementById(name).style.display = "none";
    document.getElementById("demo").style.display = "none";
    document.getElementById("head1").innerHTML = "Employee Id : " + emp_id;
    document.getElementById(next).style.display = "block";
}

function myFunction2(name, nextname) {
    document.getElementById(name).style.display = "none";
    document.getElementById("demo1").innerHTML = vehicle[nextname];
    document.getElementById(nextname).style.display = "block";
}

function collapse(name, current, next) {
    document.getElementById(current).style.display = "block";
    document.getElementById(name).style.display = "none";
    document.getElementById("demo1").style.display = "none";
    document.getElementById("head2").innerHTML = "Vehicle Type Selected : " + vh_type;
    document.getElementById(next).style.display = "block";
}

function closepricing(num) {
    var types = vh_details.type;
    var display;
    if (num == 1) {
        display = vh_details[types].daily;
    } else if (num == 2) {
        display = vh_details[types].monthly;
    } else {
        display = vh_details[types].yearly;
    }
    document.getElementById("head3").innerHTML = "Final Price : $" + display;
    document.getElementById("last").style.display = "none";
}

function validateName() {
    var name = document.getElementById("name").value;
    var reg = /\d/;
    if (name.length < 2) {
        alert("Name is not correct");
        return false;
    } else if (reg.test(name)) {
        alert("Name is not correct");
        return false;
    } else {
        myFunction('fullname', 'gender');
    }
}

function validateEmail() {
    var email = document.getElementById("email").value;
    var reg = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (reg.test(email) == false) {
        alert("Email is not correct!!!!");
        return false;
    } else {
        myFunction('emailid', 'password');
    }
}

function validatePassword() {
    var pass = document.getElementById("pass").value;
    var reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,30}$/;
    if (reg.test(pass) == false) {
        alert("Password is In correct!!!!");
        return false;
    } else {
        myFunction('password', 'confirms');
    }
}

function checkpass() {
    var pass = document.getElementById("pass").value;
    var confirm = document.getElementById("confirmpass").value;
    if (confirm == pass) {
        myFunction('confirms', 'contact');
    } else {
        alert("Password Not match previous password");
        return false;
    }
}

function validateContact() {
    var contact = document.getElementById("number").value;
    var reg = /^\d{8,10}$/;
    if (reg.test(contact)) {
        collapseEmployee('contact', 'employee', 'vehicle');
    } else {
        alert("Contact number is not correct");
        return false;
    }
}

function complexity(){
    var password =  document.getElementById("pass").value;
    document.getElementById("pass").style.borderWidth = "thick";
    if(password.length <= 10){
        document.getElementById("pass").style.borderColor = "red";
    } else if(password.length > 10 && password.length <= 12){
        document.getElementById("pass").style.borderColor = "orange";
    } else {
        document.getElementById("pass").style.borderColor = "green";
    }
}