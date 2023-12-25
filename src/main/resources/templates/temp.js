function selectPrice() {
        var buttons = document.getElementsByClassName('cls-btn-icon-price');
            for (var i = 0; i < buttons.length; i++) {
                buttons[i].addEventListener('click', function() {
                    for (var j = 0; j < buttons.length; j++) {
                        buttons[j].classList.remove('cls-pressed');
                    }
                    if(this.id == 'btn-custom-price') {
                        this.classList.add('cls-pressed');
                        document.getElementById('input-value-text').focus();
                        document.getElementById('input-value-text').select();
                        //document.getElementById('input-value-text').value = "";
                        document.getElementById('input-value-text').ariaHidden = false;
                        //Parent button that is pressed should change to red border
                        this.closest('button').classList.add('cls-pressed-edited');btn-with-input
                        //When value is inserted and focus is lost input-value-price should be set from input-value-text

                        document.getElementById('input-value-text').addEventListener('focusout', function() {
                        if(document.getElementById('input-value-price').value != "") {
                            if(this.value != "") {
                                document.getElementById('input-value-price').value = this.value;
                                this.closest('button').classList.remove('cls-pressed-edited');
                                this.closest('button').classList.add('cls-pressed');
                                console.log("Set value from custom field:" + this.value);
                            } else {
                                document.getElementById('input-value-price').value = "";
                                this.closest('button').classList.remove('cls-pressed-edited');
                                this.closest('button').classList.remove('cls-pressed');
                                console.log("Value is empty");
                                this.arialHidden = true;
                            }
                        }
                        });
                    } else {
                        this.classList.add('cls-pressed');
                        document.getElementById('input-value-price').value = this.value;
                        console.log("Set value from normal button:" + this.value);
                    }
                });
            }
    }