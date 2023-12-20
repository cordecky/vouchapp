// Twoja funkcja JavaScript do obsługi przełączania zakładek
function openForm(evt, formName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(formName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Wywołaj funkcję openForm dla pierwszego przycisku, aby pierwsza zakładka była widoczna domyślnie
document.addEventListener('DOMContentLoaded', function() {
    // Jeśli masz przyciski, które powinny być aktywne od początku
    if (document.getElementsByClassName("tablinks").length > 0) {
        openForm(event, 'VoucherName');
    }
});
