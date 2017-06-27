var exec = require('cordova/exec');
var Sunmi = {
	sendText: function (success,error,text,size,isBold,IsUnderline) {
        exec(success, error, "Sunmi", "sendText", [text,size,isBold,IsUnderline]);
    },
	sendImage: function (success,error,image) {
        exec(success, error, "Sunmi", "sendImage", [image]);
    }
};
module.exports = Sunmi;
	