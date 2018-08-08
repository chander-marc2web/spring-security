

//for registration form designing js
$(function () {
    $('.button-checkbox').each(function () {

        // Settings
        var $widget = $(this),
            $button = $widget.find('button'),
            $checkbox = $widget.find('input:checkbox'),
            color = $button.data('color'),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        // Event Handlers
        $button.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
        });

        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $button
                    .removeClass('btn-default')
                    .addClass('btn-' + color + ' active');
            }
            else {
                $button
                    .removeClass('btn-' + color + ' active')
                    .addClass('btn-default');
            }
        }

        // Initialization
        function init() {

            updateDisplay();

            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i>');
            }
        }
        init();
    });
});


// registration form validation

$(function(){
	
	$.validator.addMethod('strongPassword' , function(value,element){
		return this.optional(element)||value.length>=8 && 	/\d/.test(value) && /[a-z]/.test(value);
	},'Your Password must be at least 8 characters long and contain at least one number and one character!')
		
	
	$.validator.addMethod('noWhiteSpace' ,function(value,element){
		return this.optional(element) || /^\S+$/i.test(value);
	},'White Spaces are not allowed!')
	
	$("form[name='registration']").validate({
		
		rules:{
			userName:{
				required:true,
				noWhiteSpace:true
				},
			email:{
				required:true,
				email:true
			},
			password:{
				required:true,
				strongPassword:true,
				noWhiteSpace:true
				
			},
	password_confirmation:{
		required:true,
		equalTo:"#password"
		}
	
	},
	
	messages:{
		
		userName:{
			required:'userName is mendatory!'
		},
		password:{
			required:'Please Enter Password!'
		},
	password_confirmation:{
		required:'Please re-enter the password!',
			equalTo:'password not matched!'
	},
	email:{
		required:'please enter email!',
		email:'Enter a valid email address!'	
	}
		
	}
		
	});	
});


// login form validation

$(function(){
	
	$.validator.addMethod('strongPassword' , function(value,element){
		return this.optional(element)||value.length>=8 && 	/\d/.test(value) && /[a-z]/.test(value);
	},'Your Password must be at least 8 characters long and contain at least one number and one character!')
		
	
	$.validator.addMethod('noWhiteSpace' ,function(value,element){
		return this.optional(element) || /^\S+$/i.test(value);
	},'White Spaces are not allowed!')
	
$("form[name='login']").validate({
		
		rules:{
			
			email:{
				required:true,
				email:true
			},
			password:{
				required:true,
				strongPassword:true,
				noWhiteSpace:true
				
			}
		},

	messages:{
			
		email:{
			required:'please enter email!',
			email:'Enter a valid email address!'	
		},
		password:{
			required:'Please Enter Password!'
		}		
	
	}

});
	
});