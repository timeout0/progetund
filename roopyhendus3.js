var Resistor = /** @class */ (function () {
    function Resistor(r) {
        this.r = r;
        this.height = 30;
        this.width = 190;
        this.u = 0;
        this.i = 0;
    }
    Resistor.prototype.getResistance = function () { return this.r; };
    Resistor.prototype.setParent = function (p) {
        this.parent = p;
    };
    Resistor.prototype.draw = function (g, startx, y) {
        g.beginPath();
        g.moveTo(startx, y);
        g.lineTo(startx + this.width / 4, y);
        g.rect(startx + this.width / 4, y - 10, this.width / 2, 20);
        g.fillText(this.r + " Ω, " + this.u + " V, " + this.i.toFixed(3) + " A", startx + this.width / 4 + 1, y + 2);
        g.moveTo(startx + this.width * 3 / 4, y);
        g.lineTo(startx + this.width, y);
        g.stroke();
    };
    Resistor.prototype.getWidth = function () { return this.width; };
    Resistor.prototype.getR = function () { return this.r; };
    Resistor.prototype.setR = function (r) {
        this.r = r;
        this.i = this.u / this.r;
        if (parent) {
            this.parent.draw();
        }
    };
    Resistor.prototype.setU = function (u) {
        this.u = u;
        this.i = this.u / this.r;
    };
    Resistor.prototype.getI = function () {
        return this.i;
    };
    return Resistor;
}());
var ParallelCircuit = /** @class */ (function () {
    function ParallelCircuit(g, startx, y) {
        this.g = g;
        this.startx = startx;
        this.y = y;
        this.resistors = [];
        this.additionalWidth = 10;
        this.width = this.additionalWidth;
        this.height = 0;
        this.u = 0;
    }
    ParallelCircuit.prototype.push = function (r) {
        this.resistors.push(r);
        this.height += 40;
        if (this.width < r.width + this.additionalWidth) {
            this.width = r.width + this.additionalWidth;
        }
        r.setParent(this);
    };
    ParallelCircuit.prototype.draw = function () {
        this.g.clearRect(this.startx, this.y - this.height / 2, this.width, this.height);
        var x = this.startx;
        this.g.beginPath();
        this.g.moveTo(x, this.y);
        x += 5;
        this.g.lineTo(x, this.y);
        this.g.moveTo(x, this.y - this.height / 2 + 20);
        this.g.lineTo(x, this.y - this.height / 2 + 40 * (this.resistors.length - 1) + 20);
        this.g.stroke();
        for (var i = 0; i < this.resistors.length; i++) {
            this.resistors[i].draw(this.g, x, this.y - this.height / 2 + i * 40 + 20);
        }
        this.g.strokeStyle = "black";
        x += (this.width - this.additionalWidth);
        this.g.beginPath();
        this.g.moveTo(x, this.y - this.height / 2 + 20);
        this.g.lineTo(x, this.y - this.height / 2 + 40 * (this.resistors.length - 1) + 20);
        this.g.moveTo(x, this.y);
        x += 5;
        this.g.lineTo(x, this.y);
        this.g.stroke();
        this.g.fillText(this.u + " V, " + this.getI().toFixed(3) + " A", this.startx + 5, this.y + this.height / 2);
    };
    ParallelCircuit.prototype.setU = function (u) {
        this.u = u;
        for (var _i = 0, _a = this.resistors; _i < _a.length; _i++) {
            var resistor = _a[_i];
            resistor.setU(u);
        }
        this.draw();
    };
    ParallelCircuit.prototype.getI = function () {
        var total = 0;
        for (var _i = 0, _a = this.resistors; _i < _a.length; _i++) {
            var resistor = _a[_i];
            total += resistor.getI();
        }
        return total;
    };
    return ParallelCircuit;
}());