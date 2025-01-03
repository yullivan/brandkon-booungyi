# 토스 브랜드콘
## 카테고리
## 카테고리 목록 조회
- (GET)"/categories"
    - http://localhost:8080/categories

## 브랜드 목록 조회
- (GET)"/brands"
    - http://localhosy:8080/brands?category=cafe

## 브랜드 상세 조회
- (GET)"/brands/{brandID}
    - http://localhost:8080/brands/23

## 상품 목록 조회
- (GET)/products
  -http://localhost:8080/products
  -http://localhost:8-8-/products?brandId=23

## 인기 상품 목록 조회
- (GET)"/products/popular"
- http://localhost:8080/popular?categoryId=7
- http://localhost:8080/popular?brandId=23

## 상품 상세 조회
- (GET)"/products/{productId}
- http://localhost:8080/products/456

