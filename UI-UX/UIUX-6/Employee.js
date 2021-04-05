var emp_name,emp_email,emp_gender,emp_password,emp_confirmpass,emp_contact;
var employee = {
    "id" : emp_id,
    "name" : emp_name,
    "email" : emp_email,
    "gender" : emp_gender,
    "password" : emp_password,
    "confirm_password" : emp_confirmpass,
    "contact" : emp_contact
};

function createEmployee(){
    emp_name = document.getElementById("name").value;
    var getSelectedValue = document.querySelector('input[name="gender"]:checked');   
    emp_gender= getSelectedValue.value;
    emp_email = document.getElementById("email").value;
    emp_password = document.getElementById("pass").value;
    emp_confirmpass = document.getElementById("confirmpass").value;
    emp_contact = document.getElementById("number").value;
    employee.name = emp_name;
    employee.gender = emp_gender;
    employee.email = emp_email;
    employee.password = emp_password;
    employee.confirm_password = emp_confirmpass;
    employee.contact = emp_contact;
}