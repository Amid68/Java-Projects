import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
public class ImageProcessing {
	public static void main(String[] args) {
		try {

			int[][] imageData = imgToTwoD("./apple.jpg");
			//viewImageData(imageData);
			int[][] trimmed = trimBorders(imageData, 60);
			twoDToImage(trimmed, "./trimmed_apple.jpg");
			// int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
			//negativeColor(imageData);
			int[][] negative = negativeColor(imageData);
			twoDToImage(negative, "./negative_apple.jpg");
			
			int[][] stretched = stretchHorizontally(imageData);
			twoDToImage(stretched, "./stretched_apple.jpg");

			int[][] shrinked = shrinkVertically(imageData);
			twoDToImage(shrinked, "./shrinked_apple.jpg");

			int[][] inverted = invertImage(imageData);
			twoDToImage(inverted, "./inverted_apple.jpg");

			int[][] filtered = colorFilter(imageData, 65, 22, 120);
			twoDToImage(filtered, "./filtered_apple.jpg");

			int[][] newCanvas = new int[500][500];
			int[][] Canv = paintRandomImage(newCanvas);
			twoDToImage(Canv, "./Canva.jpg");

			int[][] newNewCanvas = new int[500][500];
			int[] newRGBA = {255, 255, 0, 255};
			int[][] canvaCanva = paintRectangle(newNewCanvas, 200, 200, 100, 100, getColorIntValFromRGBA(newRGBA));
			twoDToImage(canvaCanva, "./newCanva.jpg");

			int[][] newNewNewCanvas = new int[500][500];
			int[][] NewnewnewnewCanvas = generateRectangles(newNewNewCanvas, 1000);
			twoDToImage(NewnewnewnewCanvas, "./lastCanvas.jpg");
		} catch (Exception e) {
			System.out.println(String.format("ERROR: %s", e));
		}
    
	}

	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {

		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}
	public static int[][] negativeColor(int[][] imageTwoD) {

		int[][] negColor = new int[imageTwoD.length][imageTwoD[0].length];
		for (int i = 0; i < imageTwoD.length; i++) {
			for (int j = 0; j < imageTwoD[i].length; j++) {
				int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
				rgba[0] = 255 - rgba[0];
				rgba[1] = 255 - rgba[1];
				rgba[2] = 255 - rgba[2];
				negColor[i][j] = getColorIntValFromRGBA(rgba);
			}
		}
		return negColor;
	}
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
		int[][] stretchedImg = new int[imageTwoD.length][imageTwoD[0].length * 2];
		int it = 0;
		for (int i = 0; i < imageTwoD.length; i++) {
			for (int j = 0; j < imageTwoD[i].length; j++) {
				it = j * 2;
				stretchedImg[i][it] = imageTwoD[i][j];
				stretchedImg[i][it + 1] = imageTwoD[i][j];
			}
		}
		return stretchedImg;
	}
	public static int[][] shrinkVertically(int[][] imageTwoD) {
		int[][] shrinkedImg = new int[imageTwoD.length / 2][imageTwoD[0].length];
		int it = 0;
		for (int i = 0; i < imageTwoD.length; i++) {
			for (int j = 0; j < imageTwoD[i].length - 1; j++) {
				it = j / 2;
				shrinkedImg[it][i] = imageTwoD[j][i];
			}
		}
		return shrinkedImg;
	}
	public static int[][] invertImage(int[][] imageTwoD) {
		int[][] invertedImg = new int[imageTwoD.length][imageTwoD[0].length];
		for (int i = 0; i < imageTwoD.length; i++) {
			for (int j = 0; j < imageTwoD[0].length; j++) {
				invertedImg[i][j] = imageTwoD[(imageTwoD.length - 1) - i][(imageTwoD[i].length - 1) - j];
			}
		}
		return invertedImg;
	}
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
		int[][] filteredImg = new int[imageTwoD.length][imageTwoD[0].length];
		for (int i = 0; i < imageTwoD.length; i++) {
			for (int j = 0; j < imageTwoD[i].length; j++) {
				int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
				int newRed = rgba[0] + redChangeValue;
				int newGreen = rgba[1] + greenChangeValue;
				int newBlue = rgba[2] + blueChangeValue;
				
				if (newRed < 0) {
					newRed = 0;
				} else if (newRed > 255) {
					newRed = 255;
				} 

			    if (newGreen < 0) {
					newGreen = 0;
				} else if (newGreen > 255) {
					newGreen = 255;
				} 

				if (newBlue < 0) {
					newBlue = 0;
				} else if (newBlue > 255) {
					newBlue = 255;
				}

				rgba[0] = newRed;
				rgba[1] = newGreen;
				rgba[2] = newBlue;

				filteredImg[i][j] = getColorIntValFromRGBA(rgba);
			}
		}
		return filteredImg;
	}
	
	public static int[][] paintRandomImage(int[][] canvas) {
		Random random = new Random();
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {

				int red = random.nextInt(256);
				int green = random.nextInt(256);
				int blue = random.nextInt(256);

				int[] rgbaRandom = {red, green, blue, 255};
				canvas[i][j] = getColorIntValFromRGBA(rgbaRandom);
			}
		}
		return canvas;
	}
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				if (i >= rowPosition && i <= rowPosition + width) {
					if (j >= colPosition && j <= colPosition + height) {
						canvas[i][j] = color;
					}
				}
			}
		}
		return canvas;
	}
	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
		Random random2 = new Random();
		for (int i = 0; i < numRectangles; i++) {
			int width = random2.nextInt(canvas[0].length);
			int height = random2.nextInt(canvas.length);

			int randRows = random2.nextInt(canvas.length - height);
			int randCols = random2.nextInt(canvas[0].length - width);

			int red2 = random2.nextInt(256);
				int green2 = random2.nextInt(256);
				int blue2 = random2.nextInt(256);

				int[] rgbaRandom2 = {red2, green2, blue2, 255};
				int randomColor = getColorIntValFromRGBA(rgbaRandom2);

				canvas = paintRectangle(canvas, width, height, randRows, randCols, randomColor);
		}
		return canvas;
	}

	public static int[][] imgToTwoD(String inputFileOrLink) {
		try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];

			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}