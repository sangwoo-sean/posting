/* eslint-disable */
// prettier-ignore
export default {
    install(Vue) {
        Vue.config.globalProperties.$autoDashPhoneNumber = function (str) {
            str = str.replace(/\D/g, "");
            let tmp = "";
            if (str.length < 4) {
                return str;
            } else if (str.length < 7) {
                tmp += str.substr(0, 3);
                tmp += "-";
                tmp += str.substr(3);
                return tmp;
            } else if (str.length < 11) {
                tmp += str.substr(0, 3);
                tmp += "-";
                tmp += str.substr(3, 3);
                tmp += "-";
                tmp += str.substr(6);
                return tmp;
            } else {
                tmp += str.substr(0, 3);
                tmp += "-";
                tmp += str.substr(3, 4);
                tmp += "-";
                tmp += str.substr(7);
                return tmp;
            }
        };
        Vue.config.globalProperties.$autoDashDate = function (str) {
            str = str.replace(/\D/g, "");

            let tmp = "";
            if (str.length < 5) {
                return str;
            } else if (str.length < 7) {
                tmp += str.substr(0, 4);
                tmp += "-";
                tmp += str.substr(4, 5);
                return tmp;
            } else {
                tmp += str.substr(0, 4);
                tmp += "-";
                tmp += str.substr(4, 2);
                tmp += "-";
                tmp += str.substr(6, 2);
                return tmp;
            }
        };
        Vue.config.globalProperties.$autoDashYYYYMMDate = function (str) {
            return autoDashDate(str).substr(0, 7);
        };
        Vue.config.globalProperties.$autoDashResidentNumber = function (str) {
            str = str.replace(/\D/g, "");
            let tmp = "";
            if (str.length > 13) {
                tmp += str.substr(0, 6);
                tmp += "-";
                tmp += str.substr(6, 7);
                return tmp;
            } else if (str.length > 6) {
                tmp += str.substr(0, 6);
                tmp += "-";
                tmp += str.substr(6, str.length);
                return tmp;
            } else {
                return str;
            }
        };
        Vue.config.globalProperties.$numberWithCommas = function (x) {
            if (!x) {
                return "";
            }
            return x
                .toString()
                .trim()
                .replace(/\D/g, "")
                .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        };
        Vue.config.globalProperties.$isEmpty = function (value) {
            return (
                value === "" ||
                value === null ||
                value === false ||
                (typeof value === "object" && !Object.keys(value).length)
            );
        };
    },
};
