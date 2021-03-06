package org.jsweet.examples.blocksgame.util;

import def.js.Math;

public class Vector {

	public double x;
	public double y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static Vector fromPolar(double radius, double angle) {
		return new Vector(Math.cos(angle) * radius, Math.sin(angle) * radius);
	}

	public static Vector toDiscreteDirection(Vector vector) {
		double x, y;
		if (vector.x > 0) {
			x = 1;
		} else if (vector.x < 0) {
			x = -1;
		} else {
			x = 0;
		}
		if (vector.y > 0) {
			y = 1;
		} else if (vector.y < 0) {
			y = -1;
		} else {
			y = 0;
		}
		return new Vector(x, y);
	}

	public Vector clone() {
		return new Vector(this.x, this.y);
	}

	public Vector add(Vector vector) {
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	public Vector applyBounce(Vector hitObjectDirection) {
		this.x *= hitObjectDirection.x == 0 ? 1 : -1;
		this.y *= hitObjectDirection.y == 0 ? 1 : -1;
		return this;
	}

	public Vector times(double factor) {
		this.x *= factor;
		this.y *= factor;
		return this;
	}

	public Vector invert() {
		this.x *= -1;
		this.y *= -1;
		return this;
	}

	public Vector abs() {
		this.x = Math.abs(this.x);
		this.y = Math.abs(this.y);
		return this;
	}

	public String toString() {
		return "vector(" + this.x + "," + this.y + ")";
	}

	public boolean equals(Vector vector) {
		return this.x == vector.x && this.y == vector.y;
	}

	public double length() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public Vector normalize() {
		double l = this.length();
		this.x /= l;
		this.y /= l;
		return this;
	}

	public double dotProduct(Vector vector) {
		return this.x * vector.x + this.y * vector.y;
	}

	public double angle() {
		return Math.atan2(this.y, this.x);
	}

}
