export interface POST {
    id: string;
    postId: string;
    content: string;
    title: string;
    note: string;
    author: string;
    numberOfLike ?: number;
    numberOfShare ?: number;
    dateCreated ?: Date;
    dateUpdated ?: Date;
}