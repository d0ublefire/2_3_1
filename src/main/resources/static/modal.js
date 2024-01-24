async function openAndFillInTheModal(form, modal, id) {
    modal.show();
    let user = await getOneUser(id);
    console.log(getOneUser(id));
    form.id.value = user.id;
    form.username.value = user.username;
    form.firstname.value = user.firstName;
    form.lastname.value = user.lastName;
    form.password.value = user.password;
    form.roles.value = user.roles
}
