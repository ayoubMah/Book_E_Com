import {Fragment, useEffect, useState} from "react";
import {Product} from "../../app/models/product.ts";
import ProductList from "./ProductList.tsx";

export default function  catalog(){
    const [products , setProducts] = useState<Product[]>([]) ;
    useEffect(() => {
        fetch('http://localhost:8087/api/products?page=0&size=100\n')
            .then(response => response.json())
            .then(data => setProducts(data.content)) ;
    }, []);

    return (
        <Fragment>
            <ProductList products={products}/>
        </Fragment>
    )
}