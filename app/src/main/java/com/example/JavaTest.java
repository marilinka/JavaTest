package com.example;

import java.io.IOException;

public class JavaTest {

	public static short location(byte x, byte y)
	{
		return (short) ((x << 8)|y);
	}

	public static byte getXFromLocation(short location)
	{
		return (byte)(location >> 8);
	}

	public static byte getYFromLocation(short location)
	{
		return (byte) (location&0xFF);
	}

	public static short moveLocation(short location, byte width, byte height, String direction)
	{
		byte x = getXFromLocation (location);
		byte y = getYFromLocation (location);

		switch (direction)
		{
			case "up":
				if (y < height-1)
				{
					y+=1;
				}
				break;
			case "down":
				if (y > 0)
				{
					y-=1;
				}
				break;
			case "left":
				if (x > 0)
				{
					x-=1;
				}
				break;
			case "right":
				if (x < width - 1)
				{
					x+=1;
				}
				break;
		}
		return location (x, y);
	}
	public static void main(final String[] args) {
		byte width = 20, height = 6;
		short locationO = location ((byte) 1, (byte) 2);
		short locationA = location ((byte) 3, (byte) 3);

		boolean work = true;
		while(work)
		{
			System.out.println();

			for(byte y = (byte) (height-1); y >= 0; y--)
			{
				for (byte x = 0; x < width; x++)
				{
					short location = location (x, y);
					if (location == locationO)
					{
						System.out.print("o");
					}
					else if (location == locationA)
					{
						System.out.print("a");
					}
					else
					{
						System.out.print("-");
					}
					//github hello
				}
				System.out.println();
			}
			
			int letter = readKey();
			switch (letter)
			{
				case 'k':
					short newLocation = moveLocation (locationA, width, height, "down");
					if (newLocation != locationO)
					{
						locationA = newLocation;
					}
					break;
				case 'j':
					locationA = moveLocation (locationA, width, height, "left");
					break;
				case 'l':
					locationA = moveLocation (locationA, width, height, "right");
					break;
				case 'i':
					locationA = moveLocation (locationA, width, height, "up");
					break;
				case 's':
					locationO = moveLocation (locationO, width, height, "down");
					break;
				case 'a':
					locationO = moveLocation (locationO, width, height, "left");
					break;
				case 'd':
					locationO = moveLocation (locationO, width, height, "right");
					break;
				case 'w':
					locationO = moveLocation (locationO, width, height, "up");
					break;
				case 'q':
					work = false;
					System.out.println("Game is over");
					break;
			}
		}
	}

	private static int readKey() {
		try {
			return System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
