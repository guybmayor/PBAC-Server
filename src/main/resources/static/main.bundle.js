webpackJsonp([1],{

/***/ "../../../../../src async recursive":
/***/ (function(module, exports) {

function webpackEmptyContext(req) {
	throw new Error("Cannot find module '" + req + "'.");
}
webpackEmptyContext.keys = function() { return []; };
webpackEmptyContext.resolve = webpackEmptyContext;
module.exports = webpackEmptyContext;
webpackEmptyContext.id = "../../../../../src async recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"text-align:center\">\n  <h1>PBAC</h1>\n</div>\n\n<app-pbac></app-pbac>"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'app';
    }
    return AppComponent;
}());
AppComponent = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_5" /* Component */])({
        selector: 'app-root',
        template: __webpack_require__("../../../../../src/app/app.component.html"),
        styles: [__webpack_require__("../../../../../src/app/app.component.css")]
    })
], AppComponent);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pbac_pbac_component__ = __webpack_require__("../../../../../src/app/pbac/pbac.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_pbac_service__ = __webpack_require__("../../../../../src/app/shared/pbac.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_core__["b" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_4__pbac_pbac_component__["a" /* PbacComponent */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["a" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormsModule */],
            __WEBPACK_IMPORTED_MODULE_2__angular_forms__["b" /* ReactiveFormsModule */]
        ],
        providers: [__WEBPACK_IMPORTED_MODULE_5__shared_pbac_service__["a" /* PbacService */]],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/pbac/pbac.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".inputCol {\r\n     padding-top: .75rem;\r\n     padding-bottom: .75rem;\r\n     border: 1px solid rgba(86,61,124,.2);\r\n }\r\n\r\n input[type=file] { \r\n    -ms-flex-item-align: rigth; \r\n        -ms-grid-row-align: rigth; \r\n        align-self: rigth;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/pbac/pbac.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n    <h4 class=\"row\">Select case to test:</h4>\n\n    <div class=\"row\">\n        <span class=\"col-sm-8\">\n            <select (change)=\"selectedCase = $event.target.value\">\n                <option disabled hidden [value]=\"undefined\">-- select --</option>\n                <option *ngFor=\"let caseName of casesNames\" [value]=\"caseName\">{{caseName}}</option>\n            </select>\n            <button (click)=\"initCase(selectedCase)\">select</button>\n            <button (click)=\"loadDefaultRequests(selectedCase)\">init default</button>\n        </span>\n        <input class=\"col-sm-4\" type=\"file\" accept=\".json\" (change)=\"uploadNewCase($event)\"/>\n    </div>\n    \n    <hr *ngIf=\"caseDataHasLoad\">\n    <div *ngIf=\"caseDataHasLoad\" class=\"row\">\n        <div class=\"col\">\n            <label>Action Type</label>\n            <select [(ngModel)]=\"selectedActionType\" (ngModelChange)=\"changeActionType($event)\">\n                <option disabled [ngValue]=\"undefined\">-- select --</option>\n                <option *ngFor=\"let type of actionTypes\" [ngValue]=\"type\">{{type.name}}</option>\n            </select>\n        </div>\n\n    </div>\n    <hr *ngIf=\"selectedActionType\">\n    <form *ngIf=\"selectedActionType\" class=\"row\" (ngSubmit)=\"onSubmit()\" #requestForm=\"ngForm\">\n        <div class=\"form-group col align-self-start inputCol\">\n            <button type=\"button\" (click)=\"createUser()\">Create new user</button>\n            <br/>\n            <label for=\"userId\">User</label>\n            <select class=\"form-control\" id=\"userId\"\n                    required\n                    [(ngModel)]=\"newRequest.userId\" name=\"userId\"\n                    #userId=\"ngModel\">\n                <option disabled hidden [value]=\"undefined\">-- select --</option>\n                <option *ngFor=\"let user of users\" [value]=\"user.id\">au{{user.id}}</option>\n            </select>\n            <div [hidden]=\"userId.valid || userId.pristine\" class=\"alert alert-danger\">\n                    User is required\n            </div>\n        </div>\n\n        <div *ngIf=\"selectedActionType\">\n            <div *ngFor=\"let role of inputRoles; let i=index;\" class=\"form-group col align-self-start inputCol\">\n                <label for=\"'role' + i\">input #{{i + 1}}: {{role.name}}</label>\n                <select class=\"form-control\" id=\"'inputObj_' + i\"\n                        required\n                        [(ngModel)]=\"newRequest.objects[i].object\" name=\"'inputObj_' + i\">\n                    <option disabled hidden [ngValue]=\"selectUndefinedOptionValue\">-- select --</option>\n                    <option *ngFor=\"let obj of objects\" [ngValue]=\"obj\">O{{obj.id}}v{{obj.version}}</option>\n                </select>\n            </div>\n        </div>\n        <br/>\n        <div class=\"col\" align-self-end>\n            <button type=\"submit\" class=\"btn btn-success\" [disabled]=\"!requestForm.form.valid\">Submit</button>\n        </div>\n        <hr>\n    </form>\n\n    <div *ngFor=\"let obj of previousTransactions; let i=index;\" class=\"row\">\n        <span>{{i + 1}})&nbsp;(</span>\n        <span>au{{obj.transaction.user.id}}</span>\n        <span>,&nbsp;{{obj.transaction.action.type.name}}{{obj.transaction.action.id}}</span>\n        <span *ngFor=\"let tanInObj of obj.transaction.inputObjects\">,&nbsp;O{{tanInObj.id}}v{{tanInObj.version}}</span>\n        <span *ngFor=\"let tanOutObj of obj.transaction.outputObjects\">,&nbsp;O{{tanOutObj.id}}v{{tanOutObj.version}}</span>\n        <span>):&nbsp;</span>\n        \n        <span>&#8826;{{obj.provenance.controllDependency.action.type.name}}{{obj.provenance.controllDependency.action.id}},&nbsp;</span>\n        <span>au{{obj.provenance.controllDependency.user.id}},&nbsp;</span>\n        <span>C&#8827;</span>\n\n        <ng-template ngFor let-used [ngForOf]=\"obj.provenance.useDependencies\">\n                <span>,&nbsp;</span>\n                <span>&#8826;{{used.action.type.name}}{{used.action.id}},&nbsp;</span>\n                <span>O{{used.object.id}}v{{used.object.version}},&nbsp;</span>\n                <span>U{{used.role.name}}&#8827;</span>\n        </ng-template>\n\n        <ng-template ngFor let-generated [ngForOf]=\"obj.provenance.generatedDependencies\">\n                <span>,&nbsp;</span>\n                <span>&#8826;O{{generated.object.id}}v{{generated.object.version}},&nbsp;</span>\n                <span>{{generated.action.type.name}}{{generated.action.id}},&nbsp;</span>\n                <span>G{{generated.role.name}}&#8827;</span>\n        </ng-template>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/pbac/pbac.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_pbac_service__ = __webpack_require__("../../../../../src/app/shared/pbac.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_request_model__ = __webpack_require__("../../../../../src/app/shared/request.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_defaultCase_model__ = __webpack_require__("../../../../../src/app/shared/defaultCase.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_defaultOnlineGardingSystem_model__ = __webpack_require__("../../../../../src/app/shared/defaultOnlineGardingSystem.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_defaultParkingReportsSystem_model__ = __webpack_require__("../../../../../src/app/shared/defaultParkingReportsSystem.model.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PbacComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var PbacComponent = (function () {
    function PbacComponent(pbacService) {
        this.pbacService = pbacService;
        this.isInitDefaultRequestsIndex = -1;
        this.caseDataHasLoad = false;
    }
    PbacComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pbacService.getAllCases().subscribe(function (data) {
            _this.casesNames = data;
        });
    };
    PbacComponent.prototype.initCase = function (selectedCase) {
        var _this = this;
        if (!selectedCase) {
            return;
        }
        this.pbacService.init().subscribe(function (done) {
            _this.caseDataHasLoad = false;
            _this.loadCase = selectedCase;
            _this.users = new Array();
            _this.objects = new Array();
            _this.previousTransactions = new Array();
            _this.initRequest();
            _this.pbacService.getCaseActionTypes(_this.loadCase).subscribe(function (data) {
                _this.actionTypes = data;
                _this.caseDataHasLoad = true;
                if (_this.isInitDefaultRequestsIndex !== -1) {
                    _this.nextDefaultRequestsMode();
                }
            });
        });
    };
    PbacComponent.prototype.uploadNewCase = function (event) {
        var _this = this;
        if (event.target.files) {
            if (event.target.files.length === 1 && event.target.files[0]) {
                this.pbacService.upload(event.target.files[0]).subscribe(function (ok) {
                    _this.pbacService.getAllCases().subscribe(function (data) {
                        _this.casesNames = data;
                        _this.casesNames.forEach(function (cse) { return _this.initCase(cse); });
                    });
                    alert('File has been uploaded successfully.');
                }, function (error) {
                    alert('error - Failed to upload file.' + error);
                });
            }
            else {
                alert('error - Need to choose jdon file to upload.');
            }
        }
    };
    PbacComponent.prototype.initRequest = function () {
        this.newRequest = new __WEBPACK_IMPORTED_MODULE_2__shared_request_model__["a" /* Request */]();
        this.selectedActionType = undefined;
        this.inputRoles = undefined;
    };
    PbacComponent.prototype.loadDefaultRequests = function (selectedCase) {
        if (selectedCase === 'OnlineGardingSystem') {
            this.defaultRequests = new __WEBPACK_IMPORTED_MODULE_4__shared_defaultOnlineGardingSystem_model__["a" /* DefaultOnlineGardingSystem */]();
        }
        else if (selectedCase === 'ParkingReportsSystem') {
            this.defaultRequests = new __WEBPACK_IMPORTED_MODULE_5__shared_defaultParkingReportsSystem_model__["a" /* ParkingReportsSystem */]();
        }
        else {
            return;
        }
        this.isInitDefaultRequestsIndex = 0;
        this.initCase(selectedCase);
    };
    PbacComponent.prototype.nextDefaultRequestsMode = function () {
        var _this = this;
        if (this.isInitDefaultRequestsIndex >= this.defaultRequests.program.length) {
            this.isInitDefaultRequestsIndex = -1;
            return;
        }
        var action = this.defaultRequests.program[this.isInitDefaultRequestsIndex];
        switch (action.action) {
            case __WEBPACK_IMPORTED_MODULE_3__shared_defaultCase_model__["a" /* CaseAction */].CREATE_USER:
                this.createUser();
                break;
            case __WEBPACK_IMPORTED_MODULE_3__shared_defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST:
                this.newRequest = new __WEBPACK_IMPORTED_MODULE_2__shared_request_model__["a" /* Request */](this.users[action.data.userIndex].id, this.actionTypes[action.data.actionTypeIndex].name, this.actionTypes[action.data.actionTypeIndex].roles.filter(function (r) { return r.input; })
                    .map(function (r, i) { return new __WEBPACK_IMPORTED_MODULE_2__shared_request_model__["b" /* RequestObject */](_this.objects[action.data.objectsindexes[i]], r); }));
                this.onSubmit();
                break;
        }
    };
    PbacComponent.prototype.createUser = function () {
        var _this = this;
        this.pbacService.createUser().subscribe(function (data) {
            _this.users.push(data);
            if (_this.isInitDefaultRequestsIndex !== -1) {
                _this.isInitDefaultRequestsIndex++;
                _this.nextDefaultRequestsMode();
            }
        });
    };
    PbacComponent.prototype.changeActionType = function () {
        var _this = this;
        this.inputRoles = this.selectedActionType.roles.filter(function (r) { return r.input; });
        this.newRequest.objects = new Array(this.inputRoles.length);
        this.inputRoles.forEach(function (role, index) { return _this.newRequest.objects[index] = new __WEBPACK_IMPORTED_MODULE_2__shared_request_model__["b" /* RequestObject */](undefined, role); });
        this.newRequest.actionTypeName = this.selectedActionType.name;
    };
    PbacComponent.prototype.onSubmit = function () {
        var _this = this;
        this.pbacService.processRequest(this.loadCase, this.newRequest).subscribe(function (transaction) {
            _this.initRequest();
            _this.objects = _this.objects.concat(transaction.outputObjects);
            _this.pbacService.getLastProvenanceData(_this.loadCase).subscribe(function (provenance) {
                _this.previousTransactions.push({ transaction: transaction, provenance: provenance });
                if (_this.isInitDefaultRequestsIndex !== -1) {
                    _this.isInitDefaultRequestsIndex++;
                    _this.nextDefaultRequestsMode();
                }
            });
        }, function (error) {
            alert('Falied to procees the request.');
            _this.isInitDefaultRequestsIndex = -1;
        });
    };
    return PbacComponent;
}());
PbacComponent = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_5" /* Component */])({
        selector: 'app-pbac',
        template: __webpack_require__("../../../../../src/app/pbac/pbac.component.html"),
        styles: [__webpack_require__("../../../../../src/app/pbac/pbac.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_pbac_service__["a" /* PbacService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_pbac_service__["a" /* PbacService */]) === "function" && _a || Object])
], PbacComponent);

var _a;
//# sourceMappingURL=pbac.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/defaultCase.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CaseAction; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return CreateRequestObject; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return DefaultCase; });
var CaseAction;
(function (CaseAction) {
    CaseAction[CaseAction["CREATE_USER"] = 0] = "CREATE_USER";
    CaseAction[CaseAction["CREATE_REQUEST"] = 1] = "CREATE_REQUEST";
})(CaseAction || (CaseAction = {}));
var CreateRequestObject = (function () {
    function CreateRequestObject(userIndex, actionTypeIndex, objectsindexes) {
        this.userIndex = userIndex;
        this.actionTypeIndex = actionTypeIndex;
        this.objectsindexes = objectsindexes;
    }
    return CreateRequestObject;
}());

var DefaultCase = (function () {
    function DefaultCase() {
    }
    return DefaultCase;
}());

//# sourceMappingURL=defaultCase.model.js.map

/***/ }),

/***/ "../../../../../src/app/shared/defaultOnlineGardingSystem.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__ = __webpack_require__("../../../../../src/app/shared/defaultCase.model.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultOnlineGardingSystem; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var DefaultOnlineGardingSystem = (function (_super) {
    __extends(DefaultOnlineGardingSystem, _super);
    function DefaultOnlineGardingSystem() {
        var _this = _super.call(this) || this;
        _this.program = [];
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](0, 1, []) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](0, 5, [0]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](0, 0, [1]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](1, 2, [2]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](2, 2, [2]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](1, 3, [3]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](4, 4, [2]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](4, 6, [6, 5]) });
        return _this;
    }
    return DefaultOnlineGardingSystem;
}(__WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["c" /* DefaultCase */]));

//# sourceMappingURL=defaultOnlineGardingSystem.model.js.map

/***/ }),

/***/ "../../../../../src/app/shared/defaultParkingReportsSystem.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__ = __webpack_require__("../../../../../src/app/shared/defaultCase.model.ts");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ParkingReportsSystem; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var ParkingReportsSystem = (function (_super) {
    __extends(ParkingReportsSystem, _super);
    function ParkingReportsSystem() {
        var _this = _super.call(this) || this;
        _this.program = [];
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](0, 2, []) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](1, 4, [0]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](1, 5, [1]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](1, 5, [2]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](1, 0, [3]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](2, 3, [4]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_USER });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](3, 3, [4]) });
        _this.program.push({ action: __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["a" /* CaseAction */].CREATE_REQUEST, data: new __WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["b" /* CreateRequestObject */](2, 1, [4]) });
        return _this;
    }
    return ParkingReportsSystem;
}(__WEBPACK_IMPORTED_MODULE_0__defaultCase_model__["c" /* DefaultCase */]));

//# sourceMappingURL=defaultParkingReportsSystem.model.js.map

/***/ }),

/***/ "../../../../../src/app/shared/pbac.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PbacService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var PbacService = (function () {
    function PbacService(http) {
        this.http = http;
    }
    PbacService.prototype.init = function () {
        return this.http.post('//localhost:8080/api/init', null);
    };
    PbacService.prototype.getAllCases = function () {
        return this.http.get('//localhost:8080/api/case');
    };
    PbacService.prototype.getCaseActionTypes = function (caseName) {
        return this.http.get('//localhost:8080/api/' + caseName + '/action-type');
    };
    PbacService.prototype.createUser = function () {
        return this.http.post('//localhost:8080/api/user', null);
    };
    PbacService.prototype.processRequest = function (caseName, request) {
        console.log(request);
        return this.http.post('//localhost:8080/api/' + caseName + '/request', request);
    };
    PbacService.prototype.getLastProvenanceData = function (caseName) {
        return this.http.get('//localhost:8080/api/' + caseName + '/provenance/last');
    };
    PbacService.prototype.upload = function (file) {
        var formData = new FormData();
        formData.append('file', file, file.name);
        return this.http.post('//localhost:8080/api/upload', formData);
    };
    return PbacService;
}());
PbacService = __decorate([
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */]) === "function" && _a || Object])
], PbacService);

var _a;
//# sourceMappingURL=pbac.service.js.map

/***/ }),

/***/ "../../../../../src/app/shared/request.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Request; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return RequestObject; });
/* unused harmony export ObjectData */
var Request = (function () {
    function Request(userId, actionTypeName, objects) {
        this.userId = userId;
        this.actionTypeName = actionTypeName;
        this.objects = objects;
    }
    return Request;
}());

var RequestObject = (function () {
    function RequestObject(object, role) {
        this.object = object;
        this.role = role;
    }
    return RequestObject;
}());

var ObjectData = (function () {
    function ObjectData(id, version) {
        this.id = id;
        this.version = version;
    }
    return ObjectData;
}());

//# sourceMappingURL=request.model.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["a" /* enableProdMode */])();
}
__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map