var exec = require('cordova/exec');
var Sunmi = {
	sendText: function (success,error,text,size,isBold,IsUnderline) {
        exec(success, error, "Sunmi", "sendText", [text,size,isBold,IsUnderline]);
    }
};
module.exports = Sunmi;
