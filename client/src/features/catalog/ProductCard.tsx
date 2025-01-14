import {Product} from "../../app/models/product";
import {
    Avatar, Button,
    Card,
    CardActions,
    CardContent,
    CardHeader,
    CardMedia,
    Typography
} from "@mui/material";

interface Props{
    product : Product ;
}
export default function  productCard({product} : Props){
    const extractImageName = (item : Product) : string | null => {
        if(item &&  item.pictureUrl ){
            const parts = item.pictureUrl.split('/') ;
            if(parts.length > 0){
                return parts[parts.length - 1] ;
            }
        }
        return null ;
    }

    const formatPrice = (price: number): string => {
        return new Intl.NumberFormat('en-MA', {
            style: 'currency',
            currency: 'MAD',
            minimumFractionDigits: 2
        }).format(price);
    }
    return (
        <Card>
            <CardHeader avatar={
                <Avatar sx={{bgcolor: 'secondary.main'}}>
                    {product.name.charAt(0).toUpperCase()}
                </Avatar>
            }
                        title={product.name}
                        titleTypographyProps={{sx:{fontWeight:'bold', color: 'primary.main' }}}
            />
            <CardMedia
                sx={{ height: 140, backgroundSize:'contain'}}
                image={"/images/products/"+extractImageName(product)}
                title={product.name}
            />
            <CardContent>
                <Typography gutterBottom color='secondary' variant="h5">
                    {formatPrice(product.price)}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {product.book} / {product.category}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size = "small" > Add to Cart</Button>
                <Button size = "small" >View</Button>
            </CardActions>
        </Card>
    )
}