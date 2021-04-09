package application.Key2Keto.Shopping;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.ITextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy;

import application.Key2Keto.Recipes.*;

public class ShoppingListTest
{	
	@Test
	public void shoppingListBuildsCorrectlyTest()
	{	
		ShoppingListForTests sut = new ShoppingListForTests(new ArrayList<Recipe>()
		{{
			add(new Recipe("recipetype1", "recipename1", 55, 20.0, 15.7, 12.3, 4.0));
			add(new Recipe("recipetype2", "recipename2", 56, 18.3, 22.2, 33.2, 3.5));
			add(new Recipe("recipetype3", "recipename3", 58, 12.4, 9.5, 10.2, 2.3));
		}});
		
		for(Recipe recipe : sut.getRecipes())
		{
			recipe.addIngredient(new Ingredient("ingredient", "servesize"));
		}
		
		assertEquals("recipetype1", sut.getRecipes().get(0).getType());
		assertEquals("recipename1", sut.getRecipes().get(0).getName());
		assertEquals(56, sut.getRecipes().get(1).getTotalCalories());
		assertEquals(18.3, sut.getRecipes().get(1).getTotalCarb());
		assertEquals(9.5, sut.getRecipes().get(2).getTotalProtein());
		assertEquals(10.2, sut.getRecipes().get(2).getTotalFat());
		assertEquals(2.3, sut.getRecipes().get(2).getDietRatio());
		assertEquals("ingredient", sut.getRecipes().get(2).getIngredient().get(0).getName());
		assertEquals("servesize", sut.getRecipes().get(0).getIngredient().get(0).getServingSize());
	}
	
	@Test
	public void shoppingListFileIsCreatedTest()
	{
		ShoppingListForTests sut = new ShoppingListForTests(new ArrayList<Recipe>()
		{{
			add(new Recipe("recipetype1", "recipename1", 55, 20.0, 15.7, 12.3, 4.0));
			add(new Recipe("recipetype2", "recipename2", 56, 18.3, 22.2, 33.2, 3.5));
			add(new Recipe("recipetype3", "recipename3", 58, 12.4, 9.5, 10.2, 2.3));
		}});
		
		File shoppingList = new File("ShoppingList.pdf");
		assertTrue(shoppingList.exists());
	}
	
	@Test
	public void writingToPdfWorksTest()
	{
		PdfReader reader = null;
		PdfDocument pdfDocument = null;
		ShoppingListForTests sut = new ShoppingListForTests(new ArrayList<Recipe>()
		{{
			add(new Recipe("typetotest", "nametotest", 23, 53.2, 55.3, 17.8, 1.5));
		}});
		
		try
		{
			reader = new PdfReader("ShoppingList.pdf");
			pdfDocument = new PdfDocument(reader);
			ITextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
			
			String pdfContent = PdfTextExtractor.getTextFromPage(pdfDocument.getPage(1), strategy);
			
			assertEquals("Recipe: nametotest | 23 Calories | 53.2g Carbs | 55.3g Protein | 17.8g Fat", pdfContent);
		}
		
		catch(IOException io)
		{
			System.out.println("ERROR: issue reading file");
		}
		
		finally
		{
			try
			{
				reader.close();
				pdfDocument.close();
			}
			
			catch(IOException io)
			{
				System.out.println("ERROR: issue closing file");
			}
		}
	}
}
