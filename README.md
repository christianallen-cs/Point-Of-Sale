# UNIVERSITY AT BUFFALO

## Self Checkout Kiosk

## Overview

You will be developing software for a self-checkout kiosk using Object-Oriented Programming (OOP) principles. The kiosk will allow users/customers to input numeric barcodes for each item they want to purchase. The items will be displayed along with their prices. The software must handle various item attributes including sales tax, discounts, and bottle deposits without using conditional statements.

## No Conditionals

To adhere to the requirements of this project:
- Avoid using `if/else`, `match/case`, `throw/try/catch/finally`, `while`, `do/while`, or any direct simulation of conditionals.
- For decision-making, rely on Object-Oriented approaches and leverage polymorphism and inheritance.

## Programming Tasks

### Task 1: Items and The Checkout Machine

**Objective:** Create classes to represent items for sale and the self-checkout machine. Implement functionality for scanning items and viewing receipts.

#### Testing

**Item Class:**
- Constructor: Takes `String` description and `Double` base price.
- Methods:
  - `description()`: Returns item description.
  - `setBasePrice(Double price)`: Updates the base price.
  - `price()`: Returns the current price (base price initially).

**SelfCheckout Class:**
- Methods:
  - `numberPressed(int digit)`: Simulates number button presses.
  - `displayString()`: Returns the current display string.
  - `addItemToStore(String barcode, Item item)`: Adds an item to the store's inventory.
  - `enterPressed()`: Adds item with current barcode to the cart.
  - `itemsInCart()`: Returns a list of items in the cart.

#### Notes:
- Use a `Map` to manage items and barcodes.
- Ensure that changes in item prices reflect in the cart.

### Task 2: Sales and Tax

**Objective:** Implement price modifiers including sales, sales tax, and bottle deposits. Update the `Item` class to apply these modifiers.

#### Testing

**Modifier Abstract Class:**
- Methods:
  - `updatePrice(Double price)`: Returns the modified price.
  - `computeTax(Double price)`: Returns tax amount.

**Concrete Modifier Classes:**
- `Sale`: Reduces price by a percentage.
- `SalesTax`: Applies tax percentage to the price.
- `BottleDeposit`: Adds a fixed deposit amount.

**Item Class Updates:**
- `addModifier(Modifier modifier)`: Adds a modifier to the item.
- `price()`: Applies all modifiers to the base price.
- `tax()`: Returns the total tax from all modifiers.

**SelfCheckout Class Updates:**
- `subtotal()`: Returns the total price of items in the cart.
- `tax()`: Returns total tax for items in the cart.
- `total()`: Returns the final amount (subtotal + tax).

### Task 3: Checkout Features

**Objective:** Complete the customer checkout experience, including handling item rescanning and checkout procedures.

#### Testing

**SelfCheckout Class Updates:**
- Allow rescanning of items.
- Implement checkout button functionality:
  - On checkout, display "cash or credit".
  - On payment (cash/credit), clear the cart and start a new session.
  - Ensure `enter` does not rescan items from the previous session.

**Notes:**
- The `cash`, `credit`, and `loyalty card` buttons should only function after checkout.
- Ensure that pressing `enter` after checkout adds an "error" item if no new items are scanned.
