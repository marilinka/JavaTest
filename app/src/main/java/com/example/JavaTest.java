package com.example;

import java.io.IOException;

public class JavaTest {

	public static void main(final String[] args) {
		int width = 20, height = 6;
		int currentx = 0, currenty = 5;
		int currentx1 = 1, currenty1 = 2;

		boolean work = true;
		while(work)
		{
			System.out.println();

			for(int y = height-1; y >= 0; y--)
			{
				for (int x = 0; x < width; x++)
				{
					if (currentx == x && currenty == y) {
						System.out.print("o");
					}
					else if (currentx1 == x && currenty1 == y) {
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
			{   case 'k':
					if (currenty1 >= 1)
					{
						currenty1 = currenty1 - 1;
					}
					break;
				case 'j':
					if (currentx1 >= 1)
					{
						currentx1 = currentx1 - 1;
					}
					break;
				case 'l':
					if (currentx1 < width - 1)
					{
						currentx1 = currentx1 + 1;
					}
					break;
				case 'i':
					if (currenty1 < height - 1)
					{
						currenty1 = currenty1 + 1;
					}
					break;
				case 's':
					if (currenty >= 1)
					{
						currenty = currenty - 1;
					}
					break;
				case 'a':
					if (currentx >= 1)
					{
						currentx = currentx - 1;
					}
					break;
				case 'd':
					if (currentx < width - 1)
					{
						currentx = currentx + 1;
					}
					break;
				case 'w':
					if (currenty < height - 1)
					{
						currenty = currenty + 1;
					}
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
