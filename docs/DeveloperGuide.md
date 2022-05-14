This project is a re-creation of the popular board game, Monopoly. The rules of Monopoly have always been fascinating to me as they were all different depending on whom I played with.  These rules are widely known as "house rules". I decided to re-create Monopoly as I want to find out the rules the inventors of the game implemented. At the same time, see what kind of challenges might arise when creating an adequately complex game on the computer. 

The developer guide is used to document my implementation of the various logic behind this game. This documentation also makes use of the [Monopoly Wiki page](https://monopoly.fandom.com/wiki/Monopoly_Rules) for reference of the rules and formalities of the game. The main principle that I will be using to write this project is OOP.

## Objective of the game
The objective of the game is to become the wealthiest player through buying, renting, and trading Properties with the intention of bankrupting all opponents.

## Logistics of the game
1. Board
2. 2 Dice
3. Tokens
4. 32 Houses
5. 12 Hotels
6. 16 Community Chest cards
7. 16 Chance cards
8. 28 Title Deed cards

## The Bank
The Bank holds the Title Deeds, and the houses and hotels prior to purchase by the players. The Bank pays salaries and gives bonuses. It sells and auctions properties and hands out the proper Title Deed cards when purchased by a player, and it also sells houses and hotels to the players and loans money when required on mortgages.

The Bank also collects all taxes, fines, loans and interest. The Bank never "goes broke." If the Bank runs out of money, the Banker may issue as much as needed by writing on any ordinary paper.

The Banker will be implemented as a player with special authorities. However, the Banker will not be participating in the game.

## The Play
1. Each player throws the dice. The player with the highest total starts the play. 

2. All players start on the corner marked "GO", then throw the dice and move the number of spaces indicated by the dice.

3. After the player completed the turn, play passes to the next highest dice total. 

4. The tokens remain on the spaces occupied and proceed from that point on the player's next turn. 

5. Two or more tokens may rest on the same space at the same time.

6. Depending on the space the token reaches, the player may be entitled to buy real estate or other properties, or be obliged to pay rent, pay taxes, draw a Chance or Community Chest card, Go To Jail, etc.

7. If the player throw doubles, move the token as usual and be subject to any privileges (i.e., buying properties) or penalties pertaining to the space on which the player land; Then, retaining the dice, throw again and move the token as before. 

8. If the player throw doubles three times in succession, move the token immediately to the area marked "In Jail".

### Go
Each time a player lands on or passes over GO, whether by throwing the dice or drawing a card, the Banker pays that player a $200 salary. The $200 is paid only once each time around the board.

### Buying Property
Whenever a player lands on an unowned property the player may buy that property from the Bank at its printed price. The player will receive the Title Deed card showing ownership. Display the title deed card face up. 

If the player does not wish to buy the property, the Bank sells it through auction to the highest bidder. The highest bidder pays the Bank the amount of the bid in cash and receives the Title Deed card for that property.

Any player, including the one who declined the option to buy it at the printed price, may bid. Bidding may start at any price.

### Paying Rent
When a player lands on a property that is owned by another player, the owner collects rent from the player in accordance with the list printed on its Title Deed card. 

If the property is mortgaged, no rent can be collected. When a property is mortgaged, its Title Deed card is placed face down in front of the owner.

The owner charges double rent for **unimproved properties** in that color-group if the owner holds all the Title Deed cards (i.e., Boardwalk and Park Place, or Connecticut, Vermont and Oriental Avenues) in the color-group. This rule applies to unmortgaged properties even if another property in that color-group is mortgaged.

### Community Chest and Chance
When a player lands on either of these spaces, take the top card from the deck indicated, follow the instructions and return the card face down to the bottom of the deck. 

The "Get Out of Jail Free" card is held until used and then returned to the bottom of the deck. 

If the player who draws it does not wish to use it, then the player may sell it, at any time, to another player at a price agreeable to both.

### Jail
The player lands in Jail when...

1. The token lands on the space marked "Go to Jail",
2. The player draws a card marked "Go to Jail" or
3. The player throws doubles three times in succession.

When the player is sent to Jail, the player cannot collect the $200 salary in that move, regardless of where the token is on the board, the player must move directly into Jail. The turn ends when the player is sent to Jail.

If the player is not "sent to jail" but in the ordinary course of play lands on that space, the player is "Just Visiting", the player incurs no penalty, and the player moves ahead in the usual manner on the player's next turn.

The players can get out of Jail by...

1. Throwing doubles on any of their next three turns. If the player succeeds in doing this, the player immediately move forward the number of spaces shown by the doubles throw. The player does not take another turn.
2. Using the "Get Out of Jail Free Card"
3. Purchasing the "Get Out of Jail Free Card" from another player and playing it.
4. Paying a fine of $50 before rolling the dice on either of the next two turns. If the player does not throw doubles by the third turn, the player must pay the $50 fine. The player then get out of Jail and immediately move forward the number of spaces shown by the throw.

In Jail, the player may buy and sell property, buy and sell houses and hotels and collect rents.

### Free Parking
There is no benefit when the player lands on this space.

### Houses
Pre-requisite: Players must own all the properties in a color-group before they are allowed to buy houses from the Bank.

If the player buys one house, the player may put it on any one of those properties. The next house purchase must be erected on one of the unimproved properties of this or any other complete color-group the player owns. The price the player must pay the Bank for each house is shown on the Title Deed card for the property on which the player erects the house. 

The owner still collects double rent from an opponent who lands on the unimproved properties of their complete color-group.

The player may buy, during their turn, as many houses as their judgement and financial standing will allow. But the player must build evenly, i.e., the player cannot erect more than one house on any one property of any color-group until one house is built on every property of that group. The player may then begin on the second row of houses, and so on, up to a limit of four houses to a property.

Similarly, the player must also break down evenly if the player sells houses back to the Bank.

When the Bank has no houses to sell, players wishing to build must wait for another player to sell their houses to the Bank before building.

### Hotels
When a player has four houses on each property of a complete color-group, the player may buy a hotel from the Bank and erect it on any property of the color-group. The player returns the four houses from that property to the Bank and pays the price for the hotel as shown on the Title Deed card. 

Only one hotel may be erected on each property.

### Selling properties
Unimproved properties, railroads and utilities (but not buildings) may be sold to any player as a private transaction for any amount the owner can get. 

However, no property can be sold to another player if buildings are standing on any properties of that color-group. Any buildings so located must be sold back to the Bank before the owner can sell any property of that color-group.

Houses and Hotels may be sold back to the Bank by the owner of the property at any time for one-half the price paid. All houses on one color-group may be sold at once, or they may be sold one house at a time (one hotel equals five houses), evenly, in reverse of the manner in which they were erected.

### Mortgages
Unimproved properties can be mortgaged through the Bank at any time. 

Before an improved property can be mortgaged, all the buildings on all the properties of its color-group must be sold back to the Bank at half price. The mortgage value of each property is printed on its Title Deed card.

No rent can be collected on mortgaged properties or utilities, but rent can be collected on unmortgaged properties in the same group.

In order to lift the mortgage, the owner must pay the Bank the amount of mortgage plus 10% interest. When all the properties of a color-group are no longer mortgaged, the owner may begin to buy back houses at full price.

The player who mortgages property retains possession of it and no other player may secure it by lifting the mortgage from the Bank. However, the owner may sell this mortgaged property to another player at any agreed price. 

As the new owner, players may lift the mortgage at once, if they wish, by paying off the mortgage value plus 10% interest to the Bank. 

If the mortgage is not lifted at once, they must immediately pay the Bank 10% interest as they take the property from the previous owner. If they lift the mortgage on another turn or in between the turns of other players, they must pay the Bank an additional 10% interest as well as the amount of the mortgage.

### Bankruptcy
A player is declared bankrupt if the player owes more than they can pay either to another player or to the Bank. If the debt is to another player, the player must turn over all possessions to that player and retire from the game.

In making this settlement, if the player owns houses or hotels, the player must return these to the Bank in exchange for money to the extent of one-half the amount paid for them. This cash is given to the creditor.

If the player has mortgaged property, the player also turn this property over to the creditor but the new owner must at once pay the Bank the amount of interest on the loan. (See Mortgages)

Should the player owe the Bank, instead of another player, because of taxes or penalties, the player must turn over all assets to the Bank. In this case, the Bank immediately sells by auction all properties of the bankrupted player (except buildings). 

A bankrupt player must immediately retire from the game. The last player left in the game after all others become bankrupt wins the game.

## Implementation
### Properties (Purchasable Space)
Collecting rents and building houses requires the knowledge of the other properties (i.e. Utility has different multiplier for the rents depending on the number of utilities the player owns)

### Design Consideration
Alternative 1: Properties keep a list of properties of the same type (i.e. same color group, utility, station).
    Pro: Small overhead, only need to keep track of at most 4 properties
    Con: Creating the object for a property is very tedious
Alternative 2 (current implementation) : Properties keep a list of properties of the owner owns.
    Pro: Can just use the container that the owner already have
         Easier implementation
    Con: Large overhead, need to keep track of all the properties of the owner


