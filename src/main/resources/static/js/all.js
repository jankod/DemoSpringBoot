var tsh = {

    showWarn: function (msg) {
        Swal.fire({
            icon: 'warning',
            title: msg,
            //text: ' ' + msg,
            //footer: '<a href>Why do I have this issue?</a>'
        });
    },
    showError: function (msg) {
        return Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: ' ' + msg,
            //footer: '<a href>Why do I have this issue?</a>'
        });
    },

    showOK: function (msg, footer) {
        if (!footer) {
            footer = "";
        }
        var fire = Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Operation ' + msg,
            showConfirmButton: false,
            timer: 1500,
            footer: footer

        });
        //console.log("fire", fire);
        return fire;
    },

    handleAjaxFail: function (xhr, textStatus, errorThrown) {
        var msg = errorThrown + "\r\n" + xhr.statusText + "\r\n";
        console.log("err", msg);
        tsh.showError(xhr.responseJSON.message);
    }


};