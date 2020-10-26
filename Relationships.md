# Relationships Between Entities
Due to the fact that I distributed entities among members, some members will code entities that have relationships with
other entities. If you find yourself in that case, you need to communicate with the other member(s) while working on your task
so that both your codes work perfectly with each other after pull requests are merged. 

## Review the relationships below:

#### One-To-One Relationships:
- **Delivery & Sale**: Delivery being the optional. A customer might pick up their items. saleCode is a FK in Delivery.

#### One-To-Many Relationships:
- **Employee & Job**: Employee being the 'many' side. jobCode will be a FK in the Employee table.
- **Employee & Delivery**: Employee being the 'one' side. Delivery is optional to Employee. employeeCode will be a FK in Delivery.
- **Customer & Appointment**: Customer being the 'one' side. customerCode will be a FK in Appointment.
- **Sale & Promotion**: Promotion being the 'one' side. Both Sale and Promotion are optional to each other. promoCode will be a FK in Sale.
- **Sale & Customer**: Customer being the 'one' side. customerCode will be a FK in Sale.
- **Product & ProductCategory**: Product being the 'many' side. productCatCode will be a FK in Product.
- **Stock & ProductCategory**: Stock being the 'one' side. prodCatCode will be a unique foreign key.

#### Many-To-Many Relationships:
- **Sale & Product**: 
    - Bridge entity: **SaleProduct**.
    - One-to-many relationships: Sale & SaleProduct | Product & SaleProduct
    - Sale & Product both being 'one' sides.

<br/><br/>

**Necessary Changes to make to the UML:**
- Remove relationship Appointment & Employee
- Remove relationship Employeee & Stock
- Connect Cart to SaleProduct without a relation type and cardinalities. Make cart a value object. Carts might exist in our db for a beginning but they 
should use browser session objects for their lifespan.
- Make Promotion optional to Sale
- Sale should take customer Id as foreign key
- Connect Stock to ProductCategory instead of Product
