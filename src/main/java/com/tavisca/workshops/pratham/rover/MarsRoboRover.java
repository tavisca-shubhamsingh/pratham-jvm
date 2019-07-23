package com.tavisca.workshops.pratham.rover;

public class MarsRoboRover
{
	int xCor;
	int yCor;
	String direction;

	public MarsRoboRover()
	{
		xCor=0;
		yCor=0;
		direction="";
	}

	public MarsRoboRover(int x,int y,String dir)
	{
		xCor=x;
		yCor=y;
		direction=dir;
	}

	public void displayPosition()
	{
		System.out.println("newPosition..." + this.xCor + " " + this.yCor + " " + this.direction);
	}

	public void rove(char command)
	{
		if (this.direction.equalsIgnoreCase("N")) {
			switch (command) {
				case 'L':
					this.direction = "W";
					break;
				case 'R':
					this.direction = "E";
					break;
				case 'M':
					this.yCor++;
					break;
			}
		} else if (this.direction.equalsIgnoreCase("E")) {
			switch (command) {
				case 'L':
					this.direction = "N";
					break;
				case 'R':
					this.direction = "S";
					break;
				case 'M':
					this.xCor++;
					break;
			}
		} else if (this.direction.equalsIgnoreCase("S")) {
			switch (command) {
				case 'L':
					this.direction = "E";
					break;
				case 'R':
					this.direction = "W";
					break;
				case 'M':
					this.yCor--;
					break;
			}
		} else if (this.direction.equalsIgnoreCase("W")) {
			switch (command) {
				case 'L':
					this.direction = "S";
					break;
				case 'R':
					this.direction = "N";
					break;
				case 'M':
					this.xCor--;
					break;
			}
		}
	}


	public static void main(String[] args) {

		String currentPosition = "3 3 E";
		String commands = "MMRMMRMRRM";

		String[] positions = currentPosition.split(" ");

		int x = Integer.valueOf(positions[0]);
		int y = Integer.valueOf(positions[1]);
		String dir = positions[2];

		//rover creation
		MarsRoboRover r =new MarsRoboRover(x,y,dir);

		for (char command : commands.toCharArray()) {
			r.rove(command);
		}

		System.out.println("currentPosition..." + currentPosition);
		System.out.println("commands..." + commands);
		r.displayPosition();
	}


}